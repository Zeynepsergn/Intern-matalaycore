package tr.gov.gib.common.enums;

public enum ServiceEnum {

    OK(true,200,"Kayıtlar bulundu."),
    NOT_OK(false,400,"Kayıtlar bulunamadı.!"),
    CREATED(true,200,"Kayıtlar işlendi."),
    NOT_CREATED(false,400,"Kayıtlar işlenemedi.!"),
    SYSTEM(false,500,"Bilinmeyen hata.");

    private final boolean result;
    private final int resultCode;
    private final String resultMessage;

    ServiceEnum(boolean result, int resultCode, String resultMessage) {
        this.result = result;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public boolean isResult() {
        return result;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
