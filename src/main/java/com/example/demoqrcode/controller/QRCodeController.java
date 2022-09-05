package com.example.demoqrcode.controller;

import com.example.demoqrcode.utils.QRCodeUtil;
import com.google.zxing.WriterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/qrcode")
public class QRCodeController {


    @GetMapping
    public String convertToQRCode(@RequestParam String url) throws IOException, WriterException {
        String qrCode = QRCodeUtil.generateQRCodeImage(url,200,200);
        return qrCode;
    }

}
