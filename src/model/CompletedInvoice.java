package model;

import constants.StatusInvoice;

import java.time.LocalDate;

public class CompletedInvoice {
    private Invoice invoice;
    private StatusInvoice status;
    private LocalDate dayCompleted;

    public CompletedInvoice(Invoice invoice, StatusInvoice status, LocalDate dayCompleted) {
        this.invoice = invoice;
        this.status = status;
        this.dayCompleted = dayCompleted;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public StatusInvoice getStatus() {
        return status;
    }

    public void setStatus(StatusInvoice status) {
        this.status = status;
    }

    public LocalDate getDayCompleted() {
        return dayCompleted;
    }

    public void setDayCompleted(LocalDate dayCompleted) {
        this.dayCompleted = dayCompleted;
    }

    @Override
    public String toString() {
        System.out.printf("Hóa Đơn: %s \n Trạng thái: %s \n Ngày: %s",invoice,status,dayCompleted+ "\n");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return "";
    }
}
