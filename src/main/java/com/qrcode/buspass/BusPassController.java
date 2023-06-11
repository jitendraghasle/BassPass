package com.qrcode.buspass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.Base64;
@Controller
public class BusPassController {
    private final QRCodeGenerator qrCodeGenerator;

    public BusPassController(QRCodeGenerator qrCodeGenerator) {
        this.qrCodeGenerator = qrCodeGenerator;
    }

    @GetMapping("/bus-pass")
    public String showBusPass(Model model) throws WriterException {
        String busPassText = "Your bus pass information goes here.";

        try {
            byte[] qrCodeImage = qrCodeGenerator.generateQRCodeImage(busPassText);
            String base64Image = Base64.getEncoder().encodeToString(qrCodeImage);
            model.addAttribute("qrCodeImage", base64Image);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }

        return "bus-pass-page";
    }
}
