package com.example.demo.zxing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.io.ByteStreams;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.multi.qrcode.QRCodeMultiReader;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.List;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/9/10 10:08
 * @Description: TODO
 */
@Slf4j
public class Test {



    public static void main(String[] args) {
        replaceQrCode("D:\\new.jpg");
    }

    /**
     * 替换原图片里面的二维码
     *
     * @param path 原图地址
     * @throws NotFoundException 识别二维码失败
     */
    public static void replaceQrCode(String path) {

        try {
            List<Result> rlist = new ArrayList<>();
            // URL url = new URL(path);
            // image = ImageIO.read(url.openStream());
            BufferedImage originImage = ImageIO.read(new File(path));

            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(
                    originImage)));
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            // 设置编码格式
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            // 设置优化精度
            hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            // 设置复杂模式开启（我使用这种方式就可以识别微信的二维码了）
            hints.put(DecodeHintType.PURE_BARCODE, Boolean.TYPE);

            QRCodeMultiReader qc = new QRCodeMultiReader();// 一张图片有多张二维码
            try {
                Result[] r = qc.decodeMultiple(binaryBitmap, hints);// 解码
                if (r != null && r.length > 0) {
                    rlist.addAll(Arrays.asList(r));
                }
            } catch (NotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            if (!rlist.isEmpty()) {
                // 替换二维码图案
                Graphics2D graphics = originImage.createGraphics();
                for (Result result : rlist) {
                    //识别出原二维码中的原链，可根据自身业务给原链进行转链或替换成新的二维码，自行参考
                    BufferedImage qrImage = generateQrCodeImage(result.getText());

                    File outputfile1 = new File("temp" + (new Date()).getTime() + ".png");
                    ImageIO.write(qrImage, "png", outputfile1);

                    // 定位点的坐标，按照左下、左上、右上顺序
                    ResultPoint[] resultPoint = result.getResultPoints();
                    float x1 = resultPoint[0].getX();
                    float y1 = resultPoint[0].getY();
                    float x2 = resultPoint[1].getX();
                    float y2 = resultPoint[1].getY();

                    // 计算二维码图片边长
                    double interval = (Math.sqrt(Math.abs(x1 - x2) * Math.abs(x1 - x2) + Math.abs(y1 - y2)
                            * Math.abs(y1 - y2)));

                    // 定位点与起始点的差值
                    double deviate = interval * 0.4 / 1.4;

                    double length = interval + 2 * deviate;
                    // 根据二维码定位坐标计算起始坐标
                    int x = Math.round(x2) - (int) deviate;
                    int y = Math.round(y2) - (int) deviate;
                    graphics.drawImage(qrImage, x, y, (int) length, (int) length, null);
                }
                originImage.flush();
                graphics.dispose();
            }

            File outputfile = new File("ceshi.png");
            ImageIO.write(originImage, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成无边框二维码
     *
     * @param content 内容
     * @return 图像
     */
    public static BufferedImage generateQrCodeImage(String content) {
        BufferedImage bimage = null;
        String format = "png";// 二维码的图片格式
        HashMap<EncodeHintType, Object> hints = new HashMap<>(4);
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 0);

        // 为了无边距，需设置宽度为条码自动生成规则的宽度
        int width = new Code128Writer().encode(content).length;
        // 二维码放大倍数
        int codeMultiples = 1;
        // 获取二维码内容的宽，不含两边距，当EncodeHintType.MARGIN为0时即为二维码宽度
        int codeWidth = width * codeMultiples;
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, codeWidth, codeWidth,
                    hints);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, format, byteArrayOutputStream);
            bimage = ImageIO.read(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bimage;
    }
   /* private InputStream download(String image) throws IOException {
        URL url = new URL(image);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5 * 1000);
        try (InputStream inStream = conn.getInputStream()) {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[10240];
            int len;
            while ((len = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            inStream.close();

            return new ByteArrayInputStream(outStream.toByteArray());
        }
    }

    private String upload(InputStream inputStream, String filename) throws IOException {
        MediaType mediaType = MediaType.IMAGE_JPEG;
        if (filename.endsWith("png")) {
            mediaType = MediaType.IMAGE_PNG;
        }
        if (filename.endsWith("gif")) {
            mediaType = MediaType.IMAGE_GIF;
        }

        Resource xmlFile = new ByteArrayResource(ByteStreams.toByteArray(inputStream)) {
            @Override
            public String getFilename(){
                return filename;
            }
        };
        HttpHeaders xmlHeaders = new HttpHeaders();
        xmlHeaders.setContentType(mediaType);
        HttpEntity<Resource> xmlEntity = new HttpEntity<>(xmlFile, xmlHeaders);

        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.put("file", Collections.singletonList(xmlEntity));
        param.put("channel", Collections.singletonList("community"));
        param.put("file_type", Collections.singletonList("file"));
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(param);
        ResponseEntity<String> response = restTemplate.postForEntity("http://gom1.modianinc.com:8030/upload/rpc_media/upload_pic", entity, String.class);

        UploadDTO dto = JacksonMapper.readValue(response.getBody(), new TypeReference<UploadDTO>() {});

        return dto.getData().getFileInfos().get(0).getTargetUrl();
    }*/


    /**
     * 将BufferedImage转换为InputStream
     * @param image
     * @return
     */
    public InputStream bufferedImageToInputStream(BufferedImage image){
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", os);
            InputStream input = new ByteArrayInputStream(os.toByteArray());
            return input;
        } catch (IOException e) {
            log.error("提示:",e);
        }
        return null;
    }
}
