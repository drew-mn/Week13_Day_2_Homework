package com.example.codeclan.filesfolders.repository;

import com.example.codeclan.filesfolders.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
}
