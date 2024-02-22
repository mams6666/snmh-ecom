package com.snmhecom.entities;


import jakarta.persistence.*;
import java.io.Serializable;

//@Generated
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@ToString
@Entity
public class Product implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Setter(AccessLevel.NONE)
    @Column(name = "productId")
    private Long productId;


    @Column(name="productName")
    private String productName;

    @Column(name="productDescription")
    private String productDescription;

    @Column(name="productPrice")
    private double productPrice;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name="productColor")
    private String productColor;

    @Column(name="productSize")
    private String productSize;

    @Column(name="productSexe")
    private String productSexe;

    @Column(name="productSeason")
    private String productSeason;

    @Column(name = "quantityInStock")
    private int quantityInStock;



}
