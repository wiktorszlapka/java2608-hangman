package com.sda.hangman.domain.model;

import com.sda.hangman.domain.model.GameStatus.GameStatusHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@RunWith(Enclosed.class)

public class GameStatusTest {

    public static class GameStatusHelperTest {
//1. fraza z 1 wyrazem (anna ma zwrócić null null null null_
//2. ala ma kota (null null null ' ' null null ' ' ...itd itd

        private GameStatusHelper gameStatusHelper;

        @Before
        public void init() {
            this.gameStatusHelper = new GameStatusHelper();
        }


        @Test
        public void shouldReturArrayWithNullValuesForOneWordPharse() {
            //given

            //when
            Character[] phraseStatus = gameStatusHelper.preparePhraseState("Wielkopolska");

            //then
            assertThat(phraseStatus).containsOnlyNulls();

        }

        @Test
        public void shouldReturnArrayWithNullAndSpecialCharsValuesForMultiWordPhrase() {
            //given

            //when
            Character[] phraseState = gameStatusHelper.preparePhraseState("Ala ma-kota");

            //then
            assertThat(phraseState).containsOnly(null, ' ', '-');
            Assert.assertEquals((Character) ' ', phraseState[3]);
            Assert.assertEquals((Character) '-', phraseState[6]);
        }
    }
}