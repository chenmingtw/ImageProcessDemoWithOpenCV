package com.example.chenming.imageprocessdemowithopencv;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/**
 * Created by ChenMing on 2017/7/4.
 * Image processing by Binarization with OpenCV API
 */

public class BinarizationProcessor implements ImageProcessor {
    private final String TAG = "IPDemo/Binarization";

    @Override
    public Bitmap doProcess(Bitmap bmpIn) {
        Bitmap bmpOut = Bitmap.createBitmap(bmpIn.getWidth(), bmpIn.getHeight(), bmpIn.getConfig());
        Mat matSrc = new Mat();
        Mat matIntermediate = new Mat();
        Mat matDst = new Mat();

        Utils.bitmapToMat(bmpIn, matSrc);
        Imgproc.cvtColor(matSrc, matIntermediate, Imgproc.COLOR_RGB2GRAY);
        Imgproc.threshold(matIntermediate, matDst, 127, 255, Imgproc.THRESH_BINARY);
        Utils.matToBitmap(matDst, bmpOut);

        return bmpOut;
    }
}
