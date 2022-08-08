package com.cba.api.utils;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class BarcodeUtils {
	
	/**
	 * Helper method to generate local QR code 
	 * @param text
	 * @param width
	 * @param height
	 * @return
	 */
	public static String getQRCodeImage(String text, int width, int height)   {
		try {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageConfig con = new MatrixToImageConfig( 0xFF000002 , 0xFF) ;

        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream,con);
        byte[] pngData = pngOutputStream.toByteArray();
        return  Base64.getEncoder().encodeToString(pngData) ;
		}catch(Exception e) {
			return "";
		}
    }
	
	public static void decodeSignedJWTAndCnverttoBase64(String signedText)
	 {
	   try {
	       
	     String[]  splitSignedText = signedText.split("\\.");
	     String decodedSigned =new String(Base64.getDecoder().decode(splitSignedText[0]));
	     decodedSigned = decodedSigned +"\n Content:"+(new String(Base64.getDecoder().decode(splitSignedText[1])));
	     decodedSigned.replaceAll("\\\"", "\"");
	     System.out.println("\nDecoded Text:" + decodedSigned);
	   } catch (Exception ex) {
	      ex.printStackTrace();
	    }
	  }
	
		public static void main(String arg[]) throws Exception {
			BarcodeUtils.decodeSignedJWTAndCnverttoBase64(
					"eyJhbGciOiJSUzI1NiIsImtpZCI6IjQ0NDQwNUM3ODFFNDgyNTA3MkIzNENBNEY4QkRDNjA2Qzg2QjU3MjAiLCJ0eXAiOiJKV1QiLCJ4NXQiOiJSRVFGeDRIa2dsQnlzMHlrLUwzR0JzaHJWeUEifQ.eyJkYXRhIjoie1wiU2VsbGVyR3N0aW5cIjpcIjM3QUFHQ0s1OTcyUTZaR1wiLFwiQnV5ZXJHc3RpblwiOlwiMDlBQUFDSDc0MDlSMVpaXCIsXCJEb2NOb1wiOlwiQ1VQMzA3MjIwNzI2MDAwNlwiLFwiRG9jVHlwXCI6XCJJTlZcIixcIkRvY0R0XCI6XCIwMi8wNy8yMDIyXCIsXCJUb3RJbnZWYWxcIjoxMzU2OC44MixcIkl0ZW1DbnRcIjoxLFwiTWFpbkhzbkNvZGVcIjpcIjk5ODcyOVwiLFwiSXJuXCI6XCIyMmM4MWJjNjkyMzg5MmNjNWEwNjUyN2ExNWE1ZGM2MmVmY2UxZmVmM2VkMjM1ZDQ5MTczNjVjYzRiYTIzNjliXCIsXCJJcm5EdFwiOlwiMjAyMi0wNy0wMiAxNTo1NjowMFwifSIsImlzcyI6Ik5JQyJ9.rOjkdUAcN9IML-vRzUZPCcD69w30wviFLwgBiG1EonRpmM6jKEAQlAn9jiI8yF1fb2roOZ3J5Rq863GDsZZJfuzevZsMpfKinH5tFd1pFRKgT5w1MsIjO-bSx4bZsDtKnup5kZmjQCZcmKv_dHV9sbOW4ZbbH1wGl1HglhTuiEdJDpRhJss0Kjrpi6tuGq9BkUQM7Fa7ZNEdc2xszW-52Z_FVXOaMnAlCTBg9MYhTwAjJf6gtH03O8w2gEWo1MI8SvIuvjmh7HY8wihsYVFHj9KYqF1tzmaIbpJgmj24tlA5r2mHiW8NiKi1Fu6go-TsABjaZGllJM68vOW0CZ3OZQ");
		}

}
