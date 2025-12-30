package org.telegram.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.telegram.messenger.LocaleController;
import org.telegram.messenger.R;
import org.telegram.messenger.SharedConfig;
import org.telegram.ui.ActionBar.ActionBar;
import org.telegram.ui.ActionBar.BaseFragment;
import org.telegram.ui.ActionBar.Theme;
import org.telegram.ui.Cells.HeaderCell;
import org.telegram.ui.Cells.TextCheckCell;
import org.telegram.ui.Components.LayoutHelper;
import org.telegram.ui.Components.RecyclerListView;

public class UtilygramSettingsActivity extends BaseFragment {

    private RecyclerListView listView;
    private ListAdapter adapter;

    private int rowCount;
    private int cameraHeaderRow;
    private int cameraPreviewRow;
    private int useSystemCameraRow;

    @Override
    public boolean onFragmentCreate() {
        updateRows();
        return super.onFragmentCreate();
    }

    private void updateRows() {
        rowCount = 0;
        cameraHeaderRow = rowCount++;
        cameraPreviewRow = rowCount++;
        useSystemCameraRow = rowCount++;
    }

    @Override
    public View createView(Context context) {
        actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        actionBar.setAllowOverlayTitle(true);
        actionBar.setTitle(LocaleController.getString(R.string.UtilygramSettings));
        actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() {
            @Override
            public void onItemClick(int id) {
                if (id == -1) {
                    finishFragment();
                }
            }
        });

        fragmentView = new FrameLayout(context);
        FrameLayout frameLayout = (FrameLayout) fragmentView;
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));

        listView = new RecyclerListView(context);
        listView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        listView.setVerticalScrollBarEnabled(false);
        listView.setAdapter(adapter = new ListAdapter(context));
        frameLayout.addView(listView, LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT, LayoutHelper.MATCH_PARENT));

        listView.setOnItemClickListener((view, position) -> {
            if (position == cameraPreviewRow) {
                SharedConfig.toggleUtilyCameraPreview();
                ((TextCheckCell) view).setChecked(SharedConfig.utilyCameraPreviewEnabled);
            } else if (position == useSystemCameraRow) {
                SharedConfig.toggleUtilyUseSystemCamera();
                ((TextCheckCell) view).setChecked(SharedConfig.utilyUseSystemCamera);
            }
        });

        return fragmentView;
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {

        private final Context context;

        public ListAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getItemCount() {
            return rowCount;
        }

        @Override
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int type = holder.getItemViewType();
            return type == 1;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view;
            if (viewType == 0) {
                view = new HeaderCell(context);
                view.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else {
                view = new TextCheckCell(context);
                view.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            }
            return new RecyclerListView.Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            int viewType = holder.getItemViewType();
            if (viewType == 0) {
                HeaderCell cell = (HeaderCell) holder.itemView;
                if (position == cameraHeaderRow) {
                    cell.setText(LocaleController.getString(R.string.UtilygramCameraConfig));
                }
            } else if (viewType == 1) {
                TextCheckCell cell = (TextCheckCell) holder.itemView;
                if (position == cameraPreviewRow) {
                    cell.setTextAndCheck(
                            LocaleController.getString(R.string.UtilygramCameraPreview),
                            SharedConfig.utilyCameraPreviewEnabled,
                            true
                    );
                } else if (position == useSystemCameraRow) {
                    cell.setTextAndValueAndCheck(
                            LocaleController.getString(R.string.UtilygramUseSystemCamera),
                            LocaleController.getString(R.string.UtilygramUseSystemCameraInfo),
                            SharedConfig.utilyUseSystemCamera,
                            true,
                            false
                    );
                }
            }
        }

        @Override
        public int getItemViewType(int position) {
            if (position == cameraHeaderRow) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}