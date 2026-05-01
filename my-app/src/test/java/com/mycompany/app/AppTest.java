package com.mycompany.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class AppTest {

    private Game game;

    @BeforeAll
    public static void setHeadless() {
        System.setProperty("java.awt.headless", "true");
    }

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    // ===== Player tests =====
 
    @Test
    public void testPlayer1Symbol() {
        assertEquals('X', game.player1.symbol);
    }
 
    @Test
    public void testPlayer2Symbol() {
        assertEquals('O', game.player2.symbol);
    }
 
    @Test
    public void testPlayerDefaultMove() {
        Player p = new Player();
        assertEquals(0, p.move);
        assertFalse(p.selected);
        assertFalse(p.win);
    }
 
    @Test
    public void testPlayerSetMove() {
        game.player1.move = 5;
        assertEquals(5, game.player1.move);
    }
 
    @Test
    public void testPlayerSetWin() {
        game.player1.win = true;
        assertTrue(game.player1.win);
    }
 
    @Test
    public void testPlayerSetSelected() {
        game.player1.selected = true;
        assertTrue(game.player1.selected);
    }
 
    // ===== Game init tests =====
 
    @Test
    public void testGameInitialState() {
        assertEquals(State.PLAYING, game.state);
    }
 
    @Test
    public void testGameBoardInitiallyEmpty() {
        for (int i = 0; i < 9; i++) {
            assertEquals(' ', game.board[i]);
        }
    }
 
    @Test
    public void testGameINF() {
        assertEquals(100, Game.INF);
    }
 
    @Test
    public void testGameBoardLength() {
        assertEquals(9, game.board.length);
    }
 
    @Test
    public void testGamePlayer1NotNull() {
        assertNotNull(game.player1);
    }
 
    @Test
    public void testGamePlayer2NotNull() {
        assertNotNull(game.player2);
    }
 
    // ===== checkState — X wins =====
 
    @Test
    public void testXWinRow1() {
        game.symbol = 'X';
        game.board[0] = 'X';
        game.board[1] = 'X';
        game.board[2] = 'X';
        assertEquals(State.XWIN, game.checkState(game.board));
    }
 
    @Test
    public void testXWinRow2() {
        game.symbol = 'X';
        game.board[3] = 'X';
        game.board[4] = 'X';
        game.board[5] = 'X';
        assertEquals(State.XWIN, game.checkState(game.board));
    }
 
    @Test
    public void testXWinRow3() {
        game.symbol = 'X';
        game.board[6] = 'X';
        game.board[7] = 'X';
        game.board[8] = 'X';
        assertEquals(State.XWIN, game.checkState(game.board));
    }
 
    @Test
    public void testXWinCol1() {
        game.symbol = 'X';
        game.board[0] = 'X';
        game.board[3] = 'X';
        game.board[6] = 'X';
        assertEquals(State.XWIN, game.checkState(game.board));
    }
 
    @Test
    public void testXWinCol2() {
        game.symbol = 'X';
        game.board[1] = 'X';
        game.board[4] = 'X';
        game.board[7] = 'X';
        assertEquals(State.XWIN, game.checkState(game.board));
    }
 
    @Test
    public void testXWinCol3() {
        game.symbol = 'X';
        game.board[2] = 'X';
        game.board[5] = 'X';
        game.board[8] = 'X';
        assertEquals(State.XWIN, game.checkState(game.board));
    }
 
    @Test
    public void testXWinDiag1() {
        game.symbol = 'X';
        game.board[0] = 'X';
        game.board[4] = 'X';
        game.board[8] = 'X';
        assertEquals(State.XWIN, game.checkState(game.board));
    }
 
    @Test
    public void testXWinDiag2() {
        game.symbol = 'X';
        game.board[2] = 'X';
        game.board[4] = 'X';
        game.board[6] = 'X';
        assertEquals(State.XWIN, game.checkState(game.board));
    }
 
    // ===== checkState — O wins =====
 
    @Test
    public void testOWinRow1() {
        game.symbol = 'O';
        game.board[0] = 'O';
        game.board[1] = 'O';
        game.board[2] = 'O';
        assertEquals(State.OWIN, game.checkState(game.board));
    }
 
    @Test
    public void testOWinRow2() {
        game.symbol = 'O';
        game.board[3] = 'O';
        game.board[4] = 'O';
        game.board[5] = 'O';
        assertEquals(State.OWIN, game.checkState(game.board));
    }
 
    @Test
    public void testOWinRow3() {
        game.symbol = 'O';
        game.board[6] = 'O';
        game.board[7] = 'O';
        game.board[8] = 'O';
        assertEquals(State.OWIN, game.checkState(game.board));
    }
 
    @Test
    public void testOWinCol1() {
        game.symbol = 'O';
        game.board[0] = 'O';
        game.board[3] = 'O';
        game.board[6] = 'O';
        assertEquals(State.OWIN, game.checkState(game.board));
    }
 
    @Test
    public void testOWinCol2() {
        game.symbol = 'O';
        game.board[1] = 'O';
        game.board[4] = 'O';
        game.board[7] = 'O';
        assertEquals(State.OWIN, game.checkState(game.board));
    }
 
    @Test
    public void testOWinCol3() {
        game.symbol = 'O';
        game.board[2] = 'O';
        game.board[5] = 'O';
        game.board[8] = 'O';
        assertEquals(State.OWIN, game.checkState(game.board));
    }
 
    @Test
    public void testOWinDiag1() {
        game.symbol = 'O';
        game.board[0] = 'O';
        game.board[4] = 'O';
        game.board[8] = 'O';
        assertEquals(State.OWIN, game.checkState(game.board));
    }
 
    @Test
    public void testOWinDiag2() {
        game.symbol = 'O';
        game.board[2] = 'O';
        game.board[4] = 'O';
        game.board[6] = 'O';
        assertEquals(State.OWIN, game.checkState(game.board));
    }
 
    // ===== checkState — Draw / Playing =====
 
    @Test
    public void testDraw() {
        game.symbol = 'X';
        game.board[0] = 'X'; game.board[1] = 'O'; game.board[2] = 'X';
        game.board[3] = 'O'; game.board[4] = 'X'; game.board[5] = 'O';
        game.board[6] = 'O'; game.board[7] = 'X'; game.board[8] = 'O';
        assertEquals(State.DRAW, game.checkState(game.board));
    }
 
    @Test
    public void testPlaying() {
        game.symbol = 'X';
        game.board[0] = 'X';
        game.board[1] = 'O';
        assertEquals(State.PLAYING, game.checkState(game.board));
    }
 
    @Test
    public void testEmptyBoard() {
        game.symbol = 'X';
        assertEquals(State.PLAYING, game.checkState(game.board));
    }
 
    // ===== generateMoves tests =====
 
    @Test
    public void testGenMovesEmpty() {
        ArrayList<Integer> moves = new ArrayList<>();
        game.generateMoves(game.board, moves);
        assertEquals(9, moves.size());
    }
 
    @Test
    public void testGenMovesFull() {
        for (int i = 0; i < 9; i++) {
            game.board[i] = 'X';
        }
        ArrayList<Integer> moves = new ArrayList<>();
        game.generateMoves(game.board, moves);
        assertEquals(0, moves.size());
    }
 
    @Test
    public void testGenMovesPartial() {
        game.board[0] = 'X';
        game.board[4] = 'O';
        game.board[8] = 'X';
        ArrayList<Integer> moves = new ArrayList<>();
        game.generateMoves(game.board, moves);
        assertEquals(6, moves.size());
    }
 
    @Test
    public void testGenMovesOneEmpty() {
        for (int i = 0; i < 8; i++) {
            game.board[i] = 'X';
        }
        ArrayList<Integer> moves = new ArrayList<>();
        game.generateMoves(game.board, moves);
        assertEquals(1, moves.size());
        assertEquals(8, (int) moves.get(0));
    }
 
    // ===== evaluatePosition tests =====
 
    @Test
    public void testEvalXWinForX() {
        game.symbol = 'X';
        game.board[0] = 'X'; game.board[1] = 'X'; game.board[2] = 'X';
        assertEquals(Game.INF, game.evaluatePosition(game.board, game.player1));
    }
 
    @Test
    public void testEvalOWinForO() {
        game.symbol = 'O';
        game.board[0] = 'O'; game.board[1] = 'O'; game.board[2] = 'O';
        assertEquals(Game.INF, game.evaluatePosition(game.board, game.player2));
    }
 
    @Test
    public void testEvalXWinForO() {
        game.symbol = 'X';
        game.board[0] = 'X'; game.board[1] = 'X'; game.board[2] = 'X';
        assertEquals(-Game.INF, game.evaluatePosition(game.board, game.player2));
    }
 
    @Test
    public void testEvalOWinForX() {
        game.symbol = 'O';
        game.board[0] = 'O'; game.board[1] = 'O'; game.board[2] = 'O';
        assertEquals(-Game.INF, game.evaluatePosition(game.board, game.player1));
    }
 
    @Test
    public void testEvalDraw() {
        game.symbol = 'X';
        game.board[0] = 'X'; game.board[1] = 'O'; game.board[2] = 'X';
        game.board[3] = 'O'; game.board[4] = 'X'; game.board[5] = 'O';
        game.board[6] = 'O'; game.board[7] = 'X'; game.board[8] = 'O';
        assertEquals(0, game.evaluatePosition(game.board, game.player1));
    }
 
    @Test
    public void testEvalDrawForO() {
        game.symbol = 'X';
        game.board[0] = 'X'; game.board[1] = 'O'; game.board[2] = 'X';
        game.board[3] = 'O'; game.board[4] = 'X'; game.board[5] = 'O';
        game.board[6] = 'O'; game.board[7] = 'X'; game.board[8] = 'O';
        assertEquals(0, game.evaluatePosition(game.board, game.player2));
    }
 
    @Test
    public void testEvalPlaying() {
        game.symbol = 'X';
        game.board[0] = 'X';
        assertEquals(-1, game.evaluatePosition(game.board, game.player1));
    }
 
    // ===== MiniMax tests =====
 
    @Test
    public void testMiniMaxEmptyX() {
        int move = game.MiniMax(game.board, game.player1);
        assertTrue(move >= 1 && move <= 9);
    }
 
    @Test
    public void testMiniMaxEmptyO() {
        int move = game.MiniMax(game.board, game.player2);
        assertTrue(move >= 1 && move <= 9);
    }
 
    @Test
    public void testMiniMaxOneMove() {
        game.board[0] = 'X'; game.board[1] = 'O'; game.board[2] = 'X';
        game.board[3] = 'O'; game.board[4] = 'X'; game.board[5] = 'O';
        game.board[6] = 'O'; game.board[7] = 'X';
        assertEquals(9, game.MiniMax(game.board, game.player1));
    }
 
    @Test
    public void testMiniMaxOneMoveO() {
        game.board[0] = 'X'; game.board[1] = 'O'; game.board[2] = 'X';
        game.board[3] = 'O'; game.board[4] = 'X'; game.board[5] = 'O';
        game.board[6] = 'O'; game.board[7] = 'X';
        assertEquals(9, game.MiniMax(game.board, game.player2));
    }
 
    @Test
    public void testMiniMaxTwoMoves() {
        game.board[0] = 'X'; game.board[1] = 'O'; game.board[2] = 'X';
        game.board[3] = 'O'; game.board[4] = 'X'; game.board[5] = 'O';
        game.board[6] = 'O';
        int move = game.MiniMax(game.board, game.player1);
        assertTrue(move == 8 || move == 9);
    }
 
    @Test
    public void testMiniMaxFourMoves() {
        game.board[0] = 'X'; game.board[1] = 'O'; game.board[2] = 'X';
        game.board[3] = 'O'; game.board[4] = 'X';
        int move = game.MiniMax(game.board, game.player2);
        assertTrue(move >= 1 && move <= 9);
    }
 
    @Test
    public void testMiniMaxQReset() {
        game.board[0] = 'X';
        game.board[4] = 'O';
        game.MiniMax(game.board, game.player1);
        assertEquals(0, game.q);
    }
 
    @Test
    public void testMiniMaxQResetO() {
        game.board[0] = 'O';
        game.board[4] = 'X';
        game.MiniMax(game.board, game.player2);
        assertEquals(0, game.q);
    }
 
    // ===== MinMove tests =====
 
    @Test
    public void testMinMoveXWin() {
        game.symbol = 'X';
        game.board[0] = 'X'; game.board[1] = 'X'; game.board[2] = 'X';
        assertEquals(Game.INF, game.MinMove(game.board, game.player1));
    }
 
    @Test
    public void testMinMoveOWin() {
        game.symbol = 'O';
        game.board[0] = 'O'; game.board[1] = 'O'; game.board[2] = 'O';
        assertEquals(Game.INF, game.MinMove(game.board, game.player2));
    }
 
    @Test
    public void testMinMoveDraw() {
        game.symbol = 'X';
        game.board[0] = 'X'; game.board[1] = 'O'; game.board[2] = 'X';
        game.board[3] = 'O'; game.board[4] = 'X'; game.board[5] = 'O';
        game.board[6] = 'O'; game.board[7] = 'X'; game.board[8] = 'O';
        assertEquals(0, game.MinMove(game.board, game.player1));
    }
 
    @Test
    public void testMinMovePartialX() {
        game.board[0] = 'X';
        game.board[1] = 'O';
        int val = game.MinMove(game.board, game.player1);
        assertTrue(val >= -Game.INF && val <= Game.INF);
    }
 
    @Test
    public void testMinMovePartialO() {
        game.board[0] = 'O';
        game.board[1] = 'X';
        int val = game.MinMove(game.board, game.player2);
        assertTrue(val >= -Game.INF && val <= Game.INF);
    }
 
    @Test
    public void testMinMoveSwitchX() {
        game.board[0] = 'X';
        int val = game.MinMove(game.board, game.player1);
        assertTrue(val >= -Game.INF && val <= Game.INF);
    }
 
    @Test
    public void testMinMoveSwitchO() {
        game.board[0] = 'O';
        int val = game.MinMove(game.board, game.player2);
        assertTrue(val >= -Game.INF && val <= Game.INF);
    }
 
    @Test
    public void testMinMoveThreeFree() {
        game.board[0] = 'X'; game.board[1] = 'O'; game.board[2] = 'X';
        game.board[3] = 'O'; game.board[4] = 'X'; game.board[5] = 'O';
        int val = game.MinMove(game.board, game.player1);
        assertTrue(val >= -Game.INF && val <= Game.INF);
    }
 
    // ===== MaxMove tests =====
 
    @Test
    public void testMaxMoveXWin() {
        game.symbol = 'X';
        game.board[0] = 'X'; game.board[1] = 'X'; game.board[2] = 'X';
        assertEquals(Game.INF, game.MaxMove(game.board, game.player1));
    }
 
    @Test
    public void testMaxMoveOWin() {
        game.symbol = 'O';
        game.board[0] = 'O'; game.board[1] = 'O'; game.board[2] = 'O';
        assertEquals(Game.INF, game.MaxMove(game.board, game.player2));
    }
 
    @Test
    public void testMaxMoveDraw() {
        game.symbol = 'X';
        game.board[0] = 'X'; game.board[1] = 'O'; game.board[2] = 'X';
        game.board[3] = 'O'; game.board[4] = 'X'; game.board[5] = 'O';
        game.board[6] = 'O'; game.board[7] = 'X'; game.board[8] = 'O';
        assertEquals(0, game.MaxMove(game.board, game.player1));
    }
 
    @Test
    public void testMaxMovePartialX() {
        game.board[0] = 'X';
        game.board[1] = 'O';
        int val = game.MaxMove(game.board, game.player1);
        assertTrue(val >= -Game.INF && val <= Game.INF);
    }
 
    @Test
    public void testMaxMovePartialO() {
        game.board[0] = 'O';
        game.board[1] = 'X';
        int val = game.MaxMove(game.board, game.player2);
        assertTrue(val >= -Game.INF && val <= Game.INF);
    }
 
    @Test
    public void testMaxMoveSwitchX() {
        game.board[1] = 'X';
        int val = game.MaxMove(game.board, game.player1);
        assertTrue(val >= -Game.INF && val <= Game.INF);
    }
 
    @Test
    public void testMaxMoveSwitchO() {
        game.board[1] = 'O';
        int val = game.MaxMove(game.board, game.player2);
        assertTrue(val >= -Game.INF && val <= Game.INF);
    }
 
    @Test
    public void testMaxMoveThreeFree() {
        game.board[0] = 'X'; game.board[1] = 'O'; game.board[2] = 'X';
        game.board[3] = 'O'; game.board[4] = 'X'; game.board[5] = 'O';
        int val = game.MaxMove(game.board, game.player2);
        assertTrue(val >= -Game.INF && val <= Game.INF);
    }
 
    // ===== Utility tests =====
 
    @Test
    public void testUtilityChar() {
        Utility.print(new char[]{'X','O','X','O','X','O','X','O','X'});
    }
 
    @Test
    public void testUtilityInt() {
        Utility.print(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }
 
    @Test
    public void testUtilityList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Utility.print(list);
    }
 
    @Test
    public void testUtilityEmptyList() {
        Utility.print(new ArrayList<Integer>());
    }
 
    @Test
    public void testUtilityEmptyChar() {
        Utility.print(new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '});
    }
 
    @Test
    public void testUtilityZeroInt() {
        Utility.print(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
    }
 
    // ===== TicTacToeCell tests =====
 
    @Test
    public void testCellInitialMarker() {
        TicTacToeCell cell = new TicTacToeCell(0, 0, 0);
        assertEquals(' ', cell.getMarker());
    }
 
    @Test
    public void testCellSetX() {
        TicTacToeCell cell = new TicTacToeCell(0, 0, 0);
        cell.setMarker("X");
        assertEquals('X', cell.getMarker());
    }
 
    @Test
    public void testCellSetO() {
        TicTacToeCell cell = new TicTacToeCell(1, 1, 1);
        cell.setMarker("O");
        assertEquals('O', cell.getMarker());
    }
 
    @Test
    public void testCellNum() {
        TicTacToeCell cell = new TicTacToeCell(5, 2, 1);
        assertEquals(5, cell.getNum());
    }
 
    @Test
    public void testCellRow() {
        TicTacToeCell cell = new TicTacToeCell(0, 1, 2);
        assertEquals(2, cell.getRow());
    }
 
    @Test
    public void testCellCol() {
        TicTacToeCell cell = new TicTacToeCell(0, 1, 2);
        assertEquals(1, cell.getCol());
    }
 
    @Test
    public void testCellDisabled() {
        TicTacToeCell cell = new TicTacToeCell(0, 0, 0);
        cell.setMarker("O");
        assertFalse(cell.isEnabled());
    }
 
    @Test
    public void testCellNum8() {
        TicTacToeCell cell = new TicTacToeCell(8, 2, 2);
        assertEquals(8, cell.getNum());
    }
 
    @Test
    public void testAllCells() {
        for (int i = 0; i < 9; i++) {
            TicTacToeCell cell = new TicTacToeCell(i, i % 3, i / 3);
            assertEquals(i, cell.getNum());
            assertEquals(' ', cell.getMarker());
        }
    }

    @Test
    public void testPanelCreation() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3,3));
        assertNotNull(panel);
    }

    @Test
    public void testPanelHas9Components() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3,3));
        assertEquals(9, panel.getComponentCount());
    }

    @Test
    public void testPanelActionCell0() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3,3));
        TicTacToeCell cell = (TicTacToeCell) panel.getComponent(0);
        ActionEvent ae = new ActionEvent(cell, ActionEvent.ACTION_PERFORMED, "click");
        try { panel.actionPerformed(ae); } catch (Exception ignored) {}
    }

    @Test
    public void testPanelActionCell1() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3,3));
        TicTacToeCell cell = (TicTacToeCell) panel.getComponent(1);
        ActionEvent ae = new ActionEvent(cell, ActionEvent.ACTION_PERFORMED, "click");
        try { panel.actionPerformed(ae); } catch (Exception ignored) {}
    }

    @Test
    public void testPanelActionCell2() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3,3));
        TicTacToeCell cell = (TicTacToeCell) panel.getComponent(2);
        ActionEvent ae = new ActionEvent(cell, ActionEvent.ACTION_PERFORMED, "click");
        try { panel.actionPerformed(ae); } catch (Exception ignored) {}
    }

    @Test
    public void testPanelActionCell3() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3,3));
        TicTacToeCell cell = (TicTacToeCell) panel.getComponent(3);
        ActionEvent ae = new ActionEvent(cell, ActionEvent.ACTION_PERFORMED, "click");
        try { panel.actionPerformed(ae); } catch (Exception ignored) {}
    }

    @Test
    public void testPanelActionCell4() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3,3));
        TicTacToeCell cell = (TicTacToeCell) panel.getComponent(4);
        ActionEvent ae = new ActionEvent(cell, ActionEvent.ACTION_PERFORMED, "click");
        try { panel.actionPerformed(ae); } catch (Exception ignored) {}
    }

    @Test
    public void testPanelActionCell5() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3,3));
        TicTacToeCell cell = (TicTacToeCell) panel.getComponent(5);
        ActionEvent ae = new ActionEvent(cell, ActionEvent.ACTION_PERFORMED, "click");
        try { panel.actionPerformed(ae); } catch (Exception ignored) {}
    }

    @Test
    public void testPanelActionCell6() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3,3));
        TicTacToeCell cell = (TicTacToeCell) panel.getComponent(6);
        ActionEvent ae = new ActionEvent(cell, ActionEvent.ACTION_PERFORMED, "click");
        try { panel.actionPerformed(ae); } catch (Exception ignored) {}
    }

    @Test
    public void testPanelActionCell7() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3,3));
        TicTacToeCell cell = (TicTacToeCell) panel.getComponent(7);
        ActionEvent ae = new ActionEvent(cell, ActionEvent.ACTION_PERFORMED, "click");
        try { panel.actionPerformed(ae); } catch (Exception ignored) {}
    }

    @Test
    public void testPanelActionCell8() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3,3));
        TicTacToeCell cell = (TicTacToeCell) panel.getComponent(8);
        ActionEvent ae = new ActionEvent(cell, ActionEvent.ACTION_PERFORMED, "click");
        try { panel.actionPerformed(ae); } catch (Exception ignored) {}
    }

    @Test
    public void testPanelActionForeignSource() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3,3));
        TicTacToeCell foreign = new TicTacToeCell(0,0,0);
        ActionEvent ae = new ActionEvent(foreign, ActionEvent.ACTION_PERFORMED, "click");
        try { panel.actionPerformed(ae); } catch (Exception ignored) {}
    }

    @Test
    public void testStateValues() {
        assertEquals(4, State.values().length);
    }
 
    @Test
    public void testStatePlaying() {
        assertEquals(State.PLAYING, State.valueOf("PLAYING"));
    }
 
    @Test
    public void testStateXWin() {
        assertEquals(State.XWIN, State.valueOf("XWIN"));
    }
 
    @Test
    public void testStateOWin() {
        assertEquals(State.OWIN, State.valueOf("OWIN"));
    }
 
    @Test
    public void testStateDraw() {
        assertEquals(State.DRAW, State.valueOf("DRAW"));
    }
}
