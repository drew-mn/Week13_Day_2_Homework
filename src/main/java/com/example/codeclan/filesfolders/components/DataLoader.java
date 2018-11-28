package com.example.codeclan.filesfolders.components;

import com.example.codeclan.filesfolders.models.File;
import com.example.codeclan.filesfolders.models.Folder;
import com.example.codeclan.filesfolders.models.User;
import com.example.codeclan.filesfolders.repository.FileRepository;
import com.example.codeclan.filesfolders.repository.FolderRepository;
import com.example.codeclan.filesfolders.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    private DataLoader() {

    }

    public void run(ApplicationArguments args) throws Exception {

        User user = new User("Drew");
        userRepository.save(user);

        Folder folder1 = new Folder("Documents", user);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("Desktop", user);
        folderRepository.save(folder2);

        File file1 = new File("Homework", "txt", 1234, folder1);
        fileRepository.save(file1);

        File file2 = new File("Screenshots", "png", 4321, folder2);
        fileRepository.save(file2);

        folder1.addFile(file1);
        folder2.addFile(file2);
        folderRepository.save(folder1);
        folderRepository.save(folder2);

        user.addFolder(folder1);
        user.addFolder(folder2);
        userRepository.save(user);

    }

}
