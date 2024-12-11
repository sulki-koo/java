package javaprojectteam1;

import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Sound implements Runnable {

	private String bgmFilePath = "D:\\embededk\\files\\game.mp3"; // 배경 음악
	private String startFilePath = "D:\\embededk\\files\\start.mp3"; // 게임시작 효과음
	private String gameOverFilePath = "D:\\embededk\\files\\gameOver.mp3"; // 게임오버 효과음
	private String clearFilePath = "D:\\embededk\\files\\clear.MP3"; // 게임클리어 효과음

	@Override
	public void run() {
		while (true) {
			playBgm(); // 배경 음악 재생
		}
	}

	// 배경 음악 재생 메서드
	public void playBgm() {
		playSound(bgmFilePath); 
	}

	// 효과음 1 재생 메서드
	public void playStart() {
		new Thread(() -> playSound(startFilePath)).start();
	}

	// 효과음 2 재생 메서드
	public void playGameOver() {
		new Thread(() -> playSound(gameOverFilePath)).start(); 
	}

	// 효과음 3 재생 메서드
	public void playClear() {
		new Thread(() -> playSound(clearFilePath)).start(); 
	}

	// 공통된 메서드로 MP3 파일 재생
	private void playSound(String filePath) {
		try {
			FileInputStream fis = new FileInputStream(filePath); // MP3 파일을 읽을 입력 스트림 생성
			Player mp3Player = new Player(fis); // MP3 재생 객체 생성
			mp3Player.play(); // 파일 재생
		} catch (Exception e) {
			Thread.currentThread().interrupt(); // 스레드 중단
		}
	}
}
