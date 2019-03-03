package com.aloofwillow96.languageapp.dagger;

import com.aloofwillow96.languageapp.presenters.HomePresenter;

public interface ModuleComponent {
	HomePresenter getPresenter();
}
