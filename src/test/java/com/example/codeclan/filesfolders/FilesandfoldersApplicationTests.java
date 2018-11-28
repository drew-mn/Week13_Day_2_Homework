package com.example.codeclan.filesfolders;

import com.example.codeclan.filesfolders.models.File;
import com.example.codeclan.filesfolders.models.Folder;
import com.example.codeclan.filesfolders.models.User;
import com.example.codeclan.filesfolders.repository.FileRepository;
import com.example.codeclan.filesfolders.repository.FolderRepository;
import com.example.codeclan.filesfolders.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilesandfoldersApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	FileRepository fileRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createUserAndFolderThenSave() {
		User user = new User("Drew");
		userRepository.save(user);

		Folder folder1 = new Folder("Documents", user);
		folderRepository.save(folder1);

		userRepository.save(user);
	}

	@Test
	public void createFolderAndFileThenSave() {
		User user = new User("Drew");
		userRepository.save(user);

		Folder folder2 = new Folder("Desktop", user);
		folderRepository.save(folder2);

		File file = new File("Homework", "txt", 1234, folder2);
		fileRepository.save(file);

		folder2.addFile(file);
		folderRepository.save(folder2);
	}

}
