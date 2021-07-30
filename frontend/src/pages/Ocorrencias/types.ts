export type OccurrencesResponse = {
    content: OccurrenceItem[];
    totalPages: number;
}

export type OccurrenceItem = {
            id: number;
            longitude: number;
            latitude: number;
            dayOfTheWeek: string;
            description: string;
            felonious_description: string;
            moment: string;
            alone: boolean;
            victimGenre: string;
            victimAge: victimGenre,
            crimeTypeName: string;
            district: string;
}

export type victimGenre = 'feminino' | 'masculino';