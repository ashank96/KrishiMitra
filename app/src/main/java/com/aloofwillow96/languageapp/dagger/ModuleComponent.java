package com.aloofwillow96.languageapp.dagger;

import com.aloofwillow96.languageapp.presenters.FormPresenter;
import com.aloofwillow96.languageapp.presenters.HomePresenter;
import com.aloofwillow96.languageapp.presenters.SuggestedCropsPresenter;

public interface ModuleComponent {
	HomePresenter getHomePresenter();
	FormPresenter getFormPrsenter();
	SuggestedCropsPresenter getSuggestedCropPresenter();
}
