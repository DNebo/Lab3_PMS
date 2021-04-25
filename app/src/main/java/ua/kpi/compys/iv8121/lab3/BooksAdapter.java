package ua.kpi.compys.iv8121.lab3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ua.kpi.compys.iv8121.R;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder>  {
    private final ArrayList<Book> books;

    public BooksAdapter(ArrayList<Book> bookList) {
        books = bookList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView title, subtitle, price;
        public final ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.book_title);
            subtitle = itemView.findViewById(R.id.book_subtitle);
            price = itemView.findViewById(R.id.book_price);
            imageView = itemView.findViewById(R.id.book_image);
        }
    }

    @NonNull
    @Override
    public BooksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View library = inflater.inflate(R.layout.item_book, parent, false);
        return new ViewHolder(library);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.ViewHolder holder, int position) {
        Book book = books.get(position);

        TextView title = holder.title;
        TextView subtitle = holder.subtitle;
        TextView price = holder.price;
        ImageView imageView = holder.imageView;

        title.setText(book.getTitle());
        subtitle.setText(book.getSubtitle());
        price.setText(book.getPrice());
        imageView.setImageResource(book.getImageID());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
