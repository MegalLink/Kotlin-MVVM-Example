# Basic MVVM with live data Kotlin

## 1) Dependencies in build.gradle :app
    // ViewModel for architecture
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
    // LiveData implements observer to work with viewmodel
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
    // Fragment to create a fragment
    implementation "androidx.fragment:fragment-ktx:1.3.2"
    // Activity to create activity
    implementation "androidx.activity:activity-ktx:1.2.2"