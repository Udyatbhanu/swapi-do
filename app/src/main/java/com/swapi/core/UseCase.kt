package com.swapi.core

import io.reactivex.Single

interface UseCase<T>{
    operator fun invoke(): Single<T>
}