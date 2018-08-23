package com.example.android.smile;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;





    /**
     * {@link Adapter} is a {@link FragmentPagerAdapter} that can provide the layout for
     * each list item based on a data source which is a list of  objects.
     */
    public class Adapter extends FragmentPagerAdapter {
        private Context context;

        /**
         * Create a new {@link Adapter} object.
         *
         * @param fm is the fragment manager that will keep each fragment's state in the adapter
         *           across swipes.
         */
        public Adapter(Context context,FragmentManager fm) {
            super(fm);
            this.context=context;
        }

        /**
         * Return the {@link Fragment} that should be displayed for the given page number.
         */
        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new AlphabetFragment();
            } else if (position == 1) {
                return new NumberFragment();
            } else if (position == 2) {
                return new PhrasesFragment();
            } else {
                return new RhymesFragment();
            }
        }

        /**
         * Return the total number of pages.
         */
        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position==0)
            {
                return context.getString(R.string.category_alphabet);
            }
            else if(position==1)
            {
                return context.getString(R.string.category_number);
            }
            else if(position==2)
            {
                return context.getString(R.string.category_phrases);
            }
            else
            {
                return context.getString(R.string.category_rhymes);
            }
        }
    }


