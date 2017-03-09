package com.shzlabs.statussaver.ui.main.saved;

import com.shzlabs.statussaver.data.local.FileHelper;
import com.shzlabs.statussaver.data.model.ImageModel;
import com.shzlabs.statussaver.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by shaz on 6/3/17.
 */

public class SavedPicsPresenter extends BasePresenter<SavedPicsView> {

    @Inject
    public FileHelper fileHelper;

    @Inject
    public SavedPicsPresenter(FileHelper fileHelper) {
        this.fileHelper = fileHelper;
    }

    void setLoadingAnimation(boolean status) {
        getMvpView().displayLoadingAnimation(status);
    }

    void loadSavedImages() {
        List<ImageModel> mediaItems = fileHelper.getSavedImages();
        if (!mediaItems.isEmpty()) {
            getMvpView().displaySavedImages(mediaItems);
        }else{
            getMvpView().displayNoImagesInfo();
        }
    }

    void loadImageViewer(ImageModel imageModel) {
        getMvpView().displayImage(imageModel);
    }

}
