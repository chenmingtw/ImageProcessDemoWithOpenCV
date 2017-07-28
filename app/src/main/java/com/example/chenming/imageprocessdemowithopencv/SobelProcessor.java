package com.example.chenming.imageprocessdemowithopencv;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/**
 * Created by ChenMing on 2017/7/6.
 * Image processing by Sobel Edge Detection with OpenCV API
 */

public class SobelProcessor implements ImageProcessor {
    private final String TAG = "IPDemo/Sobel";

    @Override
    public Bitmap doProcess(Bitmap bmpIn) {
        Bitmap bmpOut = Bitmap.createBitmap(bmpIn.getWidth(), bmpIn.getHeight(), bmpIn.getConfig());
        Mat matSrc = new Mat();
        Mat matIntermediate = new Mat();
        Mat matDst = new Mat();

        Utils.bitmapToMat(bmpIn, matSrc);
        Imgproc.cvtColor(matSrc, matIntermediate, Imgproc.COLOR_RGB2GRAY);
        Imgproc.Sobel(matIntermediate, matIntermediate, CvType.CV_8U, 1, 1);
        Imgproc.cvtColor(matIntermediate, matDst ,Imgproc.COLOR_GRAY2BGR);
        Utils.matToBitmap(matDst, bmpOut);

        return bmpOut;
    }
}
