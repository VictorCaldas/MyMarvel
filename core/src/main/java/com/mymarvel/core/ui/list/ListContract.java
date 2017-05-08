

package com.mymarvel.core.ui.list;


import com.mymarvel.core.data.model.CharacterMarvel;
import com.mymarvel.core.ui.base.RemoteView;

import java.util.List;

public interface ListContract {

    interface ViewActions {
        void onInitialListRequested();

        void onListEndReached(Integer offset, Integer limit, String searchQuery);

        void onCharacterSearched(String searchQuery);
    }

    interface ListView extends RemoteView {

        void showCharacters(List<CharacterMarvel> characterList);

        void showSearchedCharacters(List<CharacterMarvel> characterList);
    }
}
