package NIO;

import java.io.IOException;
import java.nio.file.*;

/**
 * Gataullin Kamil
 * 23.09.2014 20:04
 */
public class NIOStream {
    public static String str = "./data";
    public static void main(String[] args) {
        NIOStream nio = new NIOStream();
        nio.walkFileTree();

//        nio.watcher(str);

//        copyFileTree();
    }

    public void walkFileTree() {
        Path pathSource = Paths.get("./data");
        try {
            Files.walkFileTree(pathSource, new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 1. Напишите свой Visitor для полного копирования папки
    // используйте destination.resolve(source.relativize(path))
    // где source - откуда копируем
    // destination - куда копируем
    // path - текущее местоположение

    private static void copyFileTree() {
        Path dest = Paths.get("./data2");
        Path pathSource = Paths.get("./data");
        try {
            Files.walkFileTree(pathSource, new CopyVisitor(dest, pathSource));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2. Напишите свой Visitor для поиска всех HTML страниц в папке data

    public void watcher(Path path) {
        Logger log = new Logger();
        WatchService watchService = null;
        try {
            watchService = path.getFileSystem().newWatchService();
            path.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        // Бесконечный цикл
        for (; ; ) {
            WatchKey key = null;
            try {
                key = watchService.take();
//                key = watchService.poll(10L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Итерации для каждого события
            String context = "";
            String eventToLog = "";
            for (WatchEvent event : key.pollEvents()) {
                switch (event.kind().name()) {
                    case "OVERFLOW":
                        eventToLog = "We lost some events";
                        break;
                    case "ENTRY_CREATE":
                        eventToLog = "File " + event.context() + " is created!";
                        break;
                    case "ENTRY_MODIFY":
                        eventToLog = "File " + event.context() + " is modified!";
                        break;
                    case "ENTRY_DELETE":
                        eventToLog = "File " + event.context() + " is deleted!";
                        break;
                }
                context = event.context().toString();
//                if (context.equals("Новая папка") && event.kind().name().equals("ENTRY_CREATE")) {
//                    str+="/Новая папка";
//                    System.out.println(eventToLog);
//                    log.logEvent(eventToLog);
//                    Thread wt = new WatcherThread(str);
//                    wt.start();
//                }
            }
            System.out.println(eventToLog);
            log.logEvent(eventToLog);
//          walkFileTree();
            // Сброс ключа важен для получения последующих уведомлений
            key.reset();
        }
    }

    //DZ 3. Переделайте этот Watcher чтобы он отслеживал все дочерние элементы папки
    //DZ Логирование изменений  11:09 created file
    //                                modify
    //                                deleted

}
