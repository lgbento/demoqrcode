package com.example.demoqrcode.controller;

import com.example.demoqrcode.ResponseDto;
import com.example.demoqrcode.Url;
import com.example.demoqrcode.utils.QRCodeUtil;
import com.google.zxing.WriterException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/qrcode")
public class QRCodeController {


    @PostMapping
    public ResponseDto convertToQRCode(@RequestBody Url url) throws IOException, WriterException {
        String qrCode = QRCodeUtil.generateQRCodeImage(url.getUrl(),200,200);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setUrl(qrCode);
        return responseDto;
    }

}
