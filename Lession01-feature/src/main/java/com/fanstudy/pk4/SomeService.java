package com.fanstudy.pk4;

public sealed interface SomeService permits SomeServiceImpl {
    void doThing();
}
