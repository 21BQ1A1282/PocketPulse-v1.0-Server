package com.msmk.PocketPulse.controller;

import com.msmk.PocketPulse.entity.ProfileEntity;
import com.msmk.PocketPulse.service.*;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final ExcelService excelService;
    private final IncomeService incomeService;
    private final ExpenseService expenseService;
    private final EmailService emailService;
    private final ProfileService profileService;

    @GetMapping("/income-excel-report")
    public ResponseEntity<Void> emailIncomeExcelReport() throws IOException, MessagingException {
        ProfileEntity profile = profileService.getCurrentProfile();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        excelService.writeIncomesToExcel(outputStream, incomeService.getCurrentMonthIncomesForCurrentUser());
        emailService.sendEmailWithAttachment(profile.getEmail(), "Your Income Excel Report", "Please find attached your income report.", "income_report.xlsx", outputStream.toByteArray());
        return ResponseEntity.ok(null);
    }

    @GetMapping("/expense-excel-report")
    public ResponseEntity<Void> emailExpenseExcelReport() throws IOException, MessagingException {
        ProfileEntity profile = profileService.getCurrentProfile();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        excelService.writeExpensesToExcel(outputStream, expenseService.getCurrentMonthExpensesForCurrentUser());
        emailService.sendEmailWithAttachment(profile.getEmail(), "Your Expense Excel Report", "Please find attached your expense report.", "expense_report.xlsx", outputStream.toByteArray());
        return ResponseEntity.ok(null);
    }

}
