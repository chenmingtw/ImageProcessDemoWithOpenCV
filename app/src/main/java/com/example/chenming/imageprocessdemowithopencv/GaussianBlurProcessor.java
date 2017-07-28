package com.example.chenming.imageprocessdemowithopencv;

import android.graphics.Bitmap;
import android.util.Log;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 * Created by ChenMing on 2017/7/5.
 * Image processing by Gaussian Blur with OpenCV API
 */

public class GaussianBlurProcessor implements ImageProcessor {
    private final String TAG = "IPDemo/GaussianBlur";

    // Must be positive odd number
    private int kernelSize = 3;

    @Override
    public Bitmap doProcess(Bitmap bmpIn) {
        Bitmap bmpOut = Bitmap.createBitmap(bmpIn.getWidth(), bmpIn.getHeight(), bmpIn.getConfig());
        Mat matSrc = new Mat();
        Mat matIntermediate = new Mat();
        Mat matDst = new Mat();

        Utils.bitmapToMat(bmpIn, matSrc);
        Imgproc.GaussianBlur(matSrc, matDst, new Size(kernelSize, kernelSize), 0);
        Utils.matToBitmap(matDst, bmpOut);

        return bmpOut;
    }
}
