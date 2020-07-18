package com.murari.charubeautyapp.Interface;

public interface EditImageFragmentListner {
    void onBrightnessChanged(int brightness);
    void onSaturationChanged(float saturation);
    void onConstraintChanged(float constraint);
    void onEditStarted();
    void onEditCompleted();
}
