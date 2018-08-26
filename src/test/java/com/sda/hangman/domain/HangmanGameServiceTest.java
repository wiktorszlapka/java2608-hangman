package com.sda.hangman.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class HangmanGameServiceTest {

    private HangmanGameService hangmanGameService;

    @Before
    public void init(){
        this.hangmanGameService = new HangmanGameService();
    }

    @Test
    public void shoudReturnArrayWithCharacterIndeses(){
        //given

        //when
        List<Integer> result = hangmanGameService.performCharacter('a', "Anna"); //ma wziąć litere "a" i wrzucić w tablice, pokazać na którym
        //miejscu jest. A więc jest na miejcu [0, 3]

        //then
        Assert.assertEquals(2,result.size()); //zwraca tablice o długości 2, ma 2 elementy (1 a i ostatnie jest a) =ile jest elementów trafionych
        Assert.assertEquals((Integer)0,result.get(0));
        Assert.assertEquals((Integer)3,result.get(1));
    }

    @Test
    public void shoudReturnEmptyArrayForNoExistingCharacterInPharse(){
        //given

        //when
        List<Integer> result = hangmanGameService.performCharacter('z', "ala ma kota");

        //then
        Assert.assertEquals(0,result.size());
    }

    @Test
    public void shoudReturnArrayWithCharacterIndexesFromPharseContainingiWhiteSpaces(){ //sprawdzanie jak zachowuje się ze spacją
        //given

        //when
        List<Integer> result = hangmanGameService.performCharacter('a', "Ala ma kota"); //spacje trzeba liczyć jako znak

        //then
        Assert.assertEquals(4, result.size());
        Assert.assertEquals((Integer) 0, result.get(0));
        Assert.assertEquals((Integer) 2, result.get(1));
        Assert.assertEquals((Integer) 5, result.get(2));
        Assert.assertEquals((Integer) 10, result.get(3));

    }
}
