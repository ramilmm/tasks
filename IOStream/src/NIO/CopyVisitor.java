package NIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


public class CopyVisitor extends SimpleFileVisitor<Path> {
    Path source,dest;

    public CopyVisitor(Path dest,Path source){
        this.source = source;
        this.dest = dest;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
        System.out.println("file name: " + path.getFileName());
        Path p = dest.resolve(source.relativize(path));
        try {
            Files.copy(path,p, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
        System.out.println("Directory name: " + path);
        Path p = dest.resolve(source.relativize(path));
        try {
            Files.copy(path,p,StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }

}
