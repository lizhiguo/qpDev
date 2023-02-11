rootProject.name = "qp"
include(
    "qp-bom",
    ":qp-fw:common",
    ":qp-fw:db",
    ":qp-biz:api",
    ":qp-biz:sys",
    ":qp-test:db-test:jpa-test",
    ":qp-test:db-test:mybatis-test",
    ":qp-test:db-test:merge-db-test",
    ":qp-test:db-test:kotlin-jpa-demo",
)
