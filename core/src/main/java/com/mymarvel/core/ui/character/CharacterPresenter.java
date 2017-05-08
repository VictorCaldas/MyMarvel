package com.mymarvel.core.ui.character;

import com.mymarvel.core.data.DataManager;
import com.mymarvel.core.data.model.CharacterMarvel;
import com.mymarvel.core.data.model.Comic;
import com.mymarvel.core.data.model.DataWrapper;
import com.mymarvel.core.data.network.RemoteCallback;
import com.mymarvel.core.ui.base.BasePresenter;

import java.util.List;

public class CharacterPresenter extends BasePresenter<CharacterContract.CharacterView> implements
        CharacterContract.ViewActions {

    public static final int SINGLE_ITEM_INDEX = 0;

    private DataManager mDataManager;
    private CharacterMarvel mCharacter;

    public CharacterPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void onCharacterRequested(Long characterId) {
        getCharacter(characterId);
    }

    @Override
    public void onCharacterComicsRequested(Long characterId, int limit) {
        getComicList(characterId, null, limit);
    }

    @Override
    public void onCharacterSeriesRequested(Long characterId, int limit) {
        getSeriesList(characterId, null, limit);
    }

    @Override
    public void onCharacterStoriesRequested(Long characterId, int limit) {
        getStoriesList(characterId, null, limit);
    }

    @Override
    public void onCharacterEventsRequested(Long characterId, int limit) {
        getEventsList(characterId, null, limit);
    }

    private void getCharacter(long id) {
        if (!isViewAttached()) return;
        mView.showMessageLayout(false);
        if (mCharacter != null && mCharacter.getId() == id) {
            mView.showCharacter(mCharacter);
            return;
        }

        mView.showProgress();
        mDataManager.getCharacter(id, new RemoteCallback<DataWrapper<List<CharacterMarvel>>>() {
            @Override
            public void onSuccess(DataWrapper<List<CharacterMarvel>> response) {
                if (!isViewAttached()) return;
                mView.hideProgress();
                if (response.getData().getResults().isEmpty()) {
                    mView.showError("Character does not exist");
                    return;
                }
                mCharacter = response.getData().getResults().get(SINGLE_ITEM_INDEX);
                mView.showCharacter(mCharacter);
            }

            @Override
            public void onUnauthorized() {
                if (!isViewAttached()) return;
                mView.hideProgress();
                mView.showUnauthorizedError();
            }

            @Override
            public void onFailed(Throwable throwable) {
                if (!isViewAttached()) return;
                mView.hideProgress();
                mView.showError(throwable.getMessage());
            }
        });
    }

    private void getComicList(long id, Integer offset, Integer limit) {
        if (!isViewAttached()) return;
        mView.showMessageLayout(false);
        mView.showProgress();

        mDataManager.getComics(id, offset, limit, new RemoteCallback<DataWrapper<List<Comic>>>() {
            @Override
            public void onSuccess(DataWrapper<List<Comic>> response) {
                if (!isViewAttached()) return;
                mView.hideProgress();
                if (response.getData().getResults().isEmpty()) {
                    mView.showError("Character has no comics");
                    return;
                }
                mView.showComicList(response.getData().getResults());
            }

            @Override
            public void onUnauthorized() {
                if (!isViewAttached()) return;
                mView.hideProgress();
                mView.showUnauthorizedError();
            }

            @Override
            public void onFailed(Throwable throwable) {
                if (!isViewAttached()) return;
                mView.hideProgress();
                mView.showError(throwable.getMessage());
            }
        });
    }

    private void getSeriesList(long id, Integer offset, Integer limit) {
        if (!isViewAttached()) return;
        mView.showMessageLayout(false);
        mView.showProgress();

        mDataManager.getSeries(id, offset, limit, new RemoteCallback<DataWrapper<List<Comic>>>() {
            @Override
            public void onSuccess(DataWrapper<List<Comic>> response) {
                if (!isViewAttached()) return;
                mView.hideProgress();
                if (response.getData().getResults().isEmpty()) {
                    mView.showError("Character has no series");
                    return;
                }
                mView.showSeriesList(response.getData().getResults());
            }

            @Override
            public void onUnauthorized() {
                if (!isViewAttached()) return;
                mView.hideProgress();
                mView.showUnauthorizedError();
            }

            @Override
            public void onFailed(Throwable throwable) {
                if (!isViewAttached()) return;
                mView.hideProgress();
                mView.showError(throwable.getMessage());
            }
        });
    }

    private void getStoriesList(long id, Integer offset, Integer limit) {
        if (!isViewAttached()) return;
        mView.showMessageLayout(false);
        mView.showProgress();

        mDataManager.getStories(id, offset, limit, new RemoteCallback<DataWrapper<List<Comic>>>() {
            @Override
            public void onSuccess(DataWrapper<List<Comic>> response) {
                if (!isViewAttached()) return;
                mView.hideProgress();
                if (response.getData().getResults().isEmpty()) {
                    mView.showError("Character has no stories");
                    return;
                }
                mView.showStoriesList(response.getData().getResults());
            }

            @Override
            public void onUnauthorized() {
                if (!isViewAttached()) return;
                mView.hideProgress();
                mView.showUnauthorizedError();
            }

            @Override
            public void onFailed(Throwable throwable) {
                if (!isViewAttached()) return;
                mView.hideProgress();
                mView.showError(throwable.getMessage());
            }
        });
    }

    private void getEventsList(long id, Integer offset, Integer limit) {
        if (!isViewAttached()) return;
        mView.showMessageLayout(false);
        mView.showProgress();

        mDataManager.getEvents(id, offset, limit, new RemoteCallback<DataWrapper<List<Comic>>>() {
            @Override
            public void onSuccess(DataWrapper<List<Comic>> response) {
                if (!isViewAttached()) return;
                mView.hideProgress();
                if (response.getData().getResults().isEmpty()) {
                    mView.showError("Character has no events");
                    return;
                }
                mView.showEventsList(response.getData().getResults());
            }

            @Override
            public void onUnauthorized() {
                if (!isViewAttached()) return;
                mView.hideProgress();
                mView.showUnauthorizedError();
            }

            @Override
            public void onFailed(Throwable throwable) {
                if (!isViewAttached()) return;
                mView.hideProgress();
                mView.showError(throwable.getMessage());
            }
        });
    }
}