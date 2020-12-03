package com.ludovic.vimont.domain.usecases

interface UseCase<Input, Output> {
    fun execute(input: Input): Output
}