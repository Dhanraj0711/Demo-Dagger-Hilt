package com.developerx.demo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@InstallIn(SingletonComponent::class)
@Module
object HiltModule {


    @Provides
    fun provideENG(piston: Piston): Engine {
        return Engine(piston)
    }

    @Provides
    fun provideCar(engine: Engine,@Four num:Int): Car {
        return Car(engine,num)
    }

    @Provides
    fun providePiston(numberOfPiston: NumberOfPiston): Piston {
        return Piston(numberOfPiston)
    }

    @Provides
    fun provideNum(): NumberOfPiston {
        return NumberPis()
    }

    @Provides
    @Four
    fun num():Int{
        return 5
    }

    @Provides
    @Six
    fun numS():Int{
        return 12
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Four


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Six