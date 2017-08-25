package dev.android.fursa.helpme.com.fursa.dev.common.manager;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;

import java.util.Stack;

import dev.android.fursa.helpme.com.fursa.dev.ui.activities.BaseActivity;
import dev.android.fursa.helpme.com.fursa.dev.ui.fragments.BaseFragment;

public class MyFragmentManager {
    private static final int EMPTY_FRAGMENT_STACK_SIZE = 1;

    private Stack<BaseFragment> mFragmentStack = new Stack<>();
    private BaseFragment mCurrentFragment;

    public void setFragment(BaseActivity activity, BaseFragment fragment, @IdRes int containerId) {
        if(activity != null && !activity.isFinishing() && !isAlreadyContains(fragment)) {
            FragmentTransaction ft = createAddTransaction(activity, fragment, false);
            ft.replace(containerId, fragment);
            commitAddTransaction(activity, fragment, ft, false);
        }
    }

    public void addFragment(BaseActivity activity, BaseFragment fragment, @IdRes int containerId) {
        if(activity != null && !activity.isFinishing() && !isAlreadyContains(fragment)) {
            FragmentTransaction ft = createAddTransaction(activity, fragment, true);
            ft.add(containerId, fragment);
            commitAddTransaction(activity, fragment, ft, true);
        }
    }

    public boolean removeCurrentFragment(BaseActivity activity) {
        return removeFragment(activity, mCurrentFragment);
    }

    public boolean removeFragment(BaseActivity activity, BaseFragment fragment) {
        boolean canRemove = fragment != null && mFragmentStack.size() > EMPTY_FRAGMENT_STACK_SIZE;

        if(canRemove) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            mFragmentStack.pop();
            mCurrentFragment = mFragmentStack.lastElement();
            ft.remove(fragment);
            commitTransaction(activity, ft);
        }

        return canRemove;
    }

    private FragmentTransaction createAddTransaction(BaseActivity activity, BaseFragment fragment, boolean addToBackStack) {
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();

        if(addToBackStack) {
            ft.addToBackStack(fragment.getTag());
        }

        return ft;
    }

    private void commitAddTransaction(BaseActivity activity, BaseFragment fragment, FragmentTransaction ft, boolean addToBackStack) {
        if(ft != null) {
            mCurrentFragment = fragment;
        }

        if(!addToBackStack) {
            mFragmentStack = new Stack<>();
        }

        mFragmentStack.add(fragment);
        commitTransaction(activity, ft);
    }

    private void commitTransaction(BaseActivity activity, FragmentTransaction ft) {
        ft.commit();
        activity.fragmentOnScreen(mCurrentFragment);
    }

    public boolean isAlreadyContains(BaseFragment baseFragment) {
        if(baseFragment == null) {
            return false;
        }

        return mCurrentFragment != null && mCurrentFragment.getClass().getName()
                .equals(baseFragment.getClass().getName());
    }
}
