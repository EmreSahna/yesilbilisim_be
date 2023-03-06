package org.yesilbilisim.backend.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.yesilbilisim.backend.entity.Blogs.Blog;
import org.yesilbilisim.backend.entity.Views.CardView;

import java.text.Normalizer;
import java.util.Locale;

public class RouteIdGenerator implements IdentifierGenerator {
    @Override
    public String generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        if (object instanceof Blog) {
            Blog blog = (Blog) object;
            String name = blog.getTitle();

            String[] ids = Normalizer.normalize(name, Normalizer.Form.NFD)
                    .replaceAll("[^\\p{ASCII}]", "")
                    .replaceAll("[^\\w\\- ]", "")
                    .replaceAll("\\s", " ")
                    .toLowerCase(Locale.ENGLISH)
                    .split(" ");

            String id = "";
            int i = 0;
            int j= 0;
            while (i < 3 && j < ids.length) {
                if (ids[j].length() > 0) {
                    id = id.concat(ids[j]);
                    if (i < 2){
                        id = id.concat("-");
                    }
                    i++;
                }
                j++;
            }
            return id;
        }
        if (object instanceof CardView) {
            CardView cardView = (CardView) object;
            String name = cardView.getTitle();

            String id = Normalizer.normalize(name, Normalizer.Form.NFD)
                    .replaceAll("[^\\p{ASCII}]", "")
                    .replaceAll("[^\\w\\- ]", "")
                    .replaceAll("\\s", "-")
                    .toLowerCase(Locale.ENGLISH);
            return id;
        }
        throw new HibernateException("Unsupported object type: " + object.getClass().getSimpleName());
    }
}