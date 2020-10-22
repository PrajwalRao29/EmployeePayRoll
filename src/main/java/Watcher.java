import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.attribute.*;
import java.util.*;

public class Watcher {
    public static void main(String[] args) throws IOException {
        Path dir=Paths.get("C:\\Users\\Latha r rao\\Intellij\\EmployeePayRoll\\EmpData");
        new Watcher(dir).processEvents();
    }
    private final WatchService watcher;
    private final Map<WatchKey, Path> dirWatchers;

    public Watcher(Path dir) throws IOException {
        this.watcher = FileSystems.getDefault().newWatchService();
        this.dirWatchers = new HashMap<WatchKey, Path>();
    }

    private void registerDirWatchers(Path dir) throws IOException {
        WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        dirWatchers.put(key, dir);
    }

    private void scanAndRegisterDirectories(final Path start) throws IOException {
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                registerDirWatchers(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    void processEvents() {
        while (true) {
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException e) {
                return;
            }
            Path dir = dirWatchers.get(key);
            if (dir == null) continue;
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind kind = event.kind();
                Path name = ((WatchEvent<Path>) event).context();
                Path child = dir.resolve(name);
                System.out.format("%s: %s \n", event.kind().name(), child);
                if (kind == ENTRY_CREATE) {
                    try {
                        if (Files.isDirectory(child))
                            scanAndRegisterDirectories(child);
                    } catch (IOException e) {

                    }
                }
                else if(kind.equals(ENTRY_DELETE)){
                    if(Files.isDirectory(child)) dirWatchers.remove(key);
                }
            }
            boolean valid=key.reset();
            if(!valid){
                dirWatchers.remove(key);
                if(dirWatchers.isEmpty())
                    break;
            }
        }
    }
}
