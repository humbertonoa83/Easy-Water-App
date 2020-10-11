package hp.com.planoalimentar.easy_water_app.camera;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;

public class CameraPermission {

    private final int cameraPermissionID = 101;
    private final Activity activity;

    CameraPermission(Activity activity) {
        this.activity = activity;
    }


    /**
     * Check whether camera permission is granted
     * @return true if camera permission is granted, false otherwise
     */
    boolean checkHasCameraPermission() {

        return ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Creates a camera permission request
     */
    void requestCameraPermission() {
        ActivityCompat.requestPermissions(
                activity,
                new String[]{Manifest.permission.CAMERA},
                cameraPermissionID
        );
    }

    int getCameraPermissionID() {
        return cameraPermissionID;
    }
}