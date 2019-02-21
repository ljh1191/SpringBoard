package com.myspring.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@ToString
@Getter
@RequiredArgsConstructor
public class SampleHotel {
	@NonNull
	private Chef chef;
	private String name;
//	public SampleHotel(Chef chef) {
//		this.chef = chef;
//	}
}
