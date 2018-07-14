package com.example.aluno.atividadebimestral;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BuscarImagem extends AsyncTask<String, Integer, Bitmap> {

    private Activity activity;

    public BuscarImagem(Activity activity){
        this.activity = activity;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap imagem = null;

        try {
            URL url = new URL(strings[0]);
            imagem = BitmapFactory.decodeStream(url.openStream());
        }catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagem;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap){
        super.onPostExecute(bitmap);
        ImageView imageView = (ImageView) activity.findViewById(R.id.imageId);
        imageView.setImageBitmap(bitmap);
    }
}

