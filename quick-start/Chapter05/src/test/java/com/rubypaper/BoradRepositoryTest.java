package com.rubypaper;

// import java.util.Date;

// import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoradRepositoryTest {
    @Autowired
    private BoardRepository boardRepo;

    @Test
    public void testInsertBoard() {
        // boardRepo.deleteById(5L);
    }

    
}
