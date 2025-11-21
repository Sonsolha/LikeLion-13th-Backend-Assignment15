package com.likelion.likelionmail.scheduler;

import com.likelion.likelionmail.mail.application.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailScheduler {

    private final MailService mailService;

    private boolean sent = false; // 한 번만 실행되도록 잠금

    @Scheduled(initialDelay = 60000) // 애플리케이션 시작 후 1분 뒤 실행
    public void sendOnce() {
        if (sent) return; // 이미 실행했다면 종료
        sent = true;

        mailService.sendTestMail("sonsolha1@gmail.com");
        System.out.println("1분 뒤 자동 메일 발송 완료");
    }
}
