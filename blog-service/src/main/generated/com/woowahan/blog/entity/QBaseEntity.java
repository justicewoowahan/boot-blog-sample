package com.woowahan.blog.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBaseEntity is a Querydsl query type for BaseEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QBaseEntity extends EntityPathBase<BaseEntity> {

    private static final long serialVersionUID = 1861054272L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBaseEntity baseEntity = new QBaseEntity("baseEntity");

    public final QMember createdBy;

    public final DateTimePath<java.util.Date> createdDate = createDateTime("createdDate", java.util.Date.class);

    public final BooleanPath deleted = createBoolean("deleted");

    public final QMember lastModifiedBy;

    public final DateTimePath<java.util.Date> lastModifiedDate = createDateTime("lastModifiedDate", java.util.Date.class);

    public QBaseEntity(String variable) {
        this(BaseEntity.class, forVariable(variable), INITS);
    }

    public QBaseEntity(Path<? extends BaseEntity> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBaseEntity(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBaseEntity(PathMetadata metadata, PathInits inits) {
        this(BaseEntity.class, metadata, inits);
    }

    public QBaseEntity(Class<? extends BaseEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new QMember(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.lastModifiedBy = inits.isInitialized("lastModifiedBy") ? new QMember(forProperty("lastModifiedBy"), inits.get("lastModifiedBy")) : null;
    }

}

