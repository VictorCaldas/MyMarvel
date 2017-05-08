package com.mymarvel.core.ui.character;

import com.mymarvel.core.data.model.CharacterMarvel;
import com.mymarvel.core.data.model.Comic;
import com.mymarvel.core.ui.base.RemoteView;

import java.util.List;

public interface CharacterContract {

    interface ViewActions {

        void onCharacterRequested(Long characterId);

        void onCharacterComicsRequested(Long characterId, int limit);

        void onCharacterSeriesRequested(Long characterId, int limit);

        void onCharacterStoriesRequested(Long characterId, int limit);

        void onCharacterEventsRequested(Long characterId, int limit);
    }

    interface CharacterView extends RemoteView {

        void showCharacter(CharacterMarvel character);

        void showComicList(List<Comic> comicList);

        void showSeriesList(List<Comic> seriesList);

        void showStoriesList(List<Comic> storiesList);

        void showEventsList(List<Comic> eventsList);
    }
}
