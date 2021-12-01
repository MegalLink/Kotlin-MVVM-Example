package com.example.examplemvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
//Se crea en tiempo de compilacion, y con HiltAndroid App no hay que instanciar nada de onCreate etc
@HiltAndroidApp
class ContainerApp:Application()