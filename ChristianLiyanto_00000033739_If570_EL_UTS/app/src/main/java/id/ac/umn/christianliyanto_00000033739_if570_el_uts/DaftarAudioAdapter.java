package id.ac.umn.christianliyanto_00000033739_if570_el_uts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class DaftarAudioAdapter extends RecyclerView.Adapter<DaftarAudioAdapter.ItemAudioViewHolder> {
    private LinkedList<SumberAudio> mDaftarAudio;
    private LayoutInflater mInflater;
    private Context mContext;

    public DaftarAudioAdapter(Context context,
                              LinkedList<SumberAudio> daftarAudio){
        this.mContext = context;
        this.mDaftarAudio = daftarAudio;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemAudioViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.audio_item_layout , parent , false);
        return new ItemAudioViewHolder(view, this);
    }
    @Override
    public void onBindViewHolder(@NonNull ItemAudioViewHolder holder, int position) {
        SumberAudio mSumberAudio = mDaftarAudio.get(position);
        holder.tvJudul.setText(mSumberAudio.getJudul());
        holder.tvKeterangan.setText(mSumberAudio.getKeterangan());
        holder.tvUri.setText(mSumberAudio.getVideoURI());
        holder.kotakAudio.setVideoURI(
                Uri.parse(mSumberAudio.getVideoURI()));
        holder.kotakAudio.seekTo(100);
    }
    @Override
    public int getItemCount() {
        return mDaftarAudio.size();
    }

    class ItemAudioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private VideoView kotakAudio;
        private TextView tvJudul;
        private TextView tvKeterangan;
        private TextView tvUri;
        private ImageView delete;
        private DaftarAudioAdapter mAdapter;
        private int mPosisi;
        private SumberAudio mSumberAudio;
        public ItemAudioViewHolder(@NonNull View itemView,
                                   DaftarAudioAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            kotakAudio = (VideoView) itemView.findViewById(R.id.kotakAudio);
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudul);
            tvKeterangan = (TextView) itemView.findViewById(R.id.tvKeterangan);
            tvUri = (TextView) itemView.findViewById(R.id.tvUri);
            delete = (ImageView) itemView.findViewById(R.id.delete);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPosisi = getLayoutPosition();
                    mDaftarAudio.remove(mPosisi);
                    mAdapter.notifyItemRemoved(mPosisi);
                }
            });
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            mPosisi = getLayoutPosition();
            mSumberAudio = mDaftarAudio.get(mPosisi);
            Intent detilInten = new Intent(mContext,
                    DetilAudioActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("DetilVideo",mSumberAudio);
            detilInten.putExtras(bundle);
            mContext.startActivity(detilInten);
        }
    }
}
