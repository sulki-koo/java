package javaprojectteam1;

import java.awt.Color;

import javax.swing.JLabel;

public class TimeBar extends JLabel implements Runnable {

    private int barWidth = 800; // 타임바 초기 폭
    private final int height = 25;
    private final Color color = Color.RED;

    private int second; // 제한 시간
    private volatile boolean running = false; // 스레드 실행 상태 플래그
    
    public TimeBar(int second) {
        setOpaque(true); // 불투명도 설정
        setBackground(color);
        setSize(barWidth, height); // 초기 크기 설정
        this.second = second;
    }

    public void stop() {
        running = false; // 타임바 실행 상태를 멈춤
    }

    public synchronized void reset(int newTime) {
        stop(); // reset 호출 시 타임바를 멈춤
        this.second = newTime; // 새로운 시간 설정
        this.barWidth = 800; // 타임바의 폭 초기화
        setSize(barWidth, height); // UI 업데이트
        revalidate();
        repaint();
    }
    @Override
    public void run() {
        running = true; // 실행 시작
        double decrease = (second * 1000) / barWidth; // 폭 감소 속도 계산
        while (barWidth > 0 && running) {
            try {
                barWidth -= 1;
                setSize(barWidth, height); // UI 업데이트
                revalidate();
                repaint();
                Thread.sleep(((int)decrease)-1);
            } catch (InterruptedException ex) {
                break; // 스레드 종료
            }
        }
    }
}
