package com.woowahan.blog.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = 573874892L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPost post = new QPost("post");

    public final QBaseEntity _super;

    public final QBlog blog;

    public final ListPath<Comment, QComment> comments = this.<Comment, QComment>createList("comments", Comment.class, QComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    // inherited
    public final QMember createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate;

    //inherited
    public final BooleanPath deleted;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    // inherited
    public final QMember lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedDate;

    public final StringPath title = createString("title");

    public QPost(String variable) {
        this(Post.class, forVariable(variable), INITS);
    }

    public QPost(Path<? extends Post> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPost(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPost(PathMetadata metadata, PathInits inits) {
        this(Post.class, metadata, inits);
    }

    public QPost(Class<? extends Post> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QBaseEntity(type, metadata, inits);
        this.blog = inits.isInitialized("blog") ? new QBlog(forProperty("blog"), inits.get("blog")) : null;
        this.createdBy = _super.createdBy;
        this.createdDate = _super.createdDate;
        this.deleted = _super.deleted;
        this.lastModifiedBy = _super.lastModifiedBy;
        this.lastModifiedDate = _super.lastModifiedDate;
    }

}

