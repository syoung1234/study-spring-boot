package com.rubypaper;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class JPAClient {
    public static void main(String[] args) {
        // EntityManager 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
        EntityManager em = emf.createEntityManager();

        // Transaction 생성
        EntityTransaction tx = em.getTransaction();

        try {
            // Transaction 시작
            tx.begin();

            Board board = new Board();
            board.setTitle("JPA 제목");
            board.setWriter("관리자");
            board.setContent("JPA 글 등록 잘 되네요.");
            board.setCreateDate(new Date());
            board.setCnt(0L);

            // 글 등록
            em.persist(board);

            // 글 상세 조회
            Board searchBoard = em.find(Board.class, 1L);
            System.out.println("---> " + searchBoard.toString());

            // 수정할 게시글 조회
            Board board2 = em.find(Board.class, 1L);
            board2.setTitle("검색한 게시글의 제목 수정");

            // 삭제할 게시글 조회
            // Board board1 = em.find(Board.class, 2L);
            // board1.setSeq(2L);

            // 게시글 삭제
            // em.remove(board1);

            // 글 목록 조회
            String jpq1 = "select b from Board b order by b.seq desc";
            List<Board> boardList = em.createQuery(jpq1, Board.class).getResultList();
            for (Board brd : boardList) {
                System.out.println("---> " + brd.toString());
            }

            // Transaction commit 
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Transaction rollback
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
    
}
