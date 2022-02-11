CREATE TABLE items(
      code VARCHAR(10) PRIMARY KEY,
      title VARCHAR(250) NOT NULL,
      image VARCHAR(500) NOT NULL,
      rating ENUM('1','2','3','4','5') NOT NULL,
      qty INT NOT NULL,
      unit_price DECIMAL(5,2) NOT NULL,
      description MEDIUMTEXT NOT NULL
);

DROP TABLE items;

INSERT INTO items (code, image, title, rating, unit_price, qty, description)
VALUES ('I001',
        'https://m.media-amazon.com/images/I/71NTi82uBEL._AC_UL320_.jpg',
        'Apple AirPods with Charging Case',
        3,
        299,
        5,
        '<div>Lorem ipsum dolor <b>sit</b> amet, consectetur adipisicing elit. Aliquid asperiores assumenda eligendi ex exercitationem
        facilis, fugiat iste laborum libero molestias nemo nostrum numquam officia optio placeat possimus sed sunt ut.
      </div>
      <div>Ad alias commodi consequuntur deserunt dicta est eveniet excepturi fuga fugit illo illum minus molestias
        mollitia, nam necessitatibus nesciunt nostrum odio odit officiis porro provident quam quas reiciendis sint ut.
      </div>
      <div>Consequatur dignissimos necessitatibus optio temporibus voluptatem? Dolor maiores neque perferendis praesentium
        soluta! Aspernatur dicta dolor incidunt minima molestias, nihil pariatur perferendis porro possimus praesentium
        provident quasi sit! Dolore placeat, repudiandae?
      </div>'),
       ('I002',
        'https://m.media-amazon.com/images/I/81Sxdp0JBLL._AC_UL320_.jpg',
        'Nintendo Switch - Animal Crossing: New Horizons Edition - Switch',
        4,
        55,
        8, ''),
       ('I003',
        'https://m.media-amazon.com/images/I/61i421VnFYL._AC_UL320_.jpg',
        'Nintendo Switch with Gray Joy‑Con - HAC-001(-01)',
        5,
        55,
        4, ''),
       ('I004',
        'https://m.media-amazon.com/images/I/71qodgwQQ7S._AC_UL320_.jpg',
        'Acer Aspire 5 A515-56-36UT Slim Laptop | 15.6\' Full HD Display | 11th Gen Intel Core i3-1115G4',
        5,
        413.99,
        10, ''),
       ('I005',
        'https://m.media-amazon.com/images/I/61O9tWR6WDS._AC_UL320_.jpg',
        'PlayStation DualSense Wireless Controller – Midnight Black',
        4,
        69,
        8, ''),
       ('I006',
        'https://m.media-amazon.com/images/I/51pbZ+OFuCS._AC_UY218_.jpg',
        'Madden NFL 22 - PlayStation 4',
        3,
        39.99,
        8, '');